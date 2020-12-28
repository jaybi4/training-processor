# Training Processor
The use case of this project is to parse an input XML and map it to a different structure (e.g. JSON).

The options to perform the mapping are basically two:
- A mapper that traverses the XML imperatively looking for the fields we want to map.
- A mapper that has precompiled paths where to find the value for each field.

The second option has been implemented in this project. Spring ASM is used to parse the classes graph and compute the SpEL (Spring Expression Language) for the fields annotated. The output is a map we can use afterwards to retrieve the mapped value by invoking the SpEL expression.

The entry point are the Java files generated using an XSD (TrainingCenterDatabasev2 provided as an example). The idea is to annotate each Java field with its corresponding mapping to a JSON field:

```java
public static class SubmissionDate {
  
  @FieldMapping("applicationDate")
  protected XMLGregorianCalendar value;
}
```

In compilation time we traverse all Java files to calculate the corresponding paths for each field (the entry point is _FieldMapGenerator_ invoked from the POM file). Following with the above example, _SubmissionDate_ is a field of the class _Example_, which in turn is a field of _RootExample_. In this case the path to the field would be:

```
ApplicationDate = RootExample.Example.SubmissionDate
```

Here it comes into play SpEL (Spring Expression Language). We can run this expression (_RootExample.Example.SubmissionDate_) against the _RootExample_ object to obtain the _applicationDate_ value.

_SpELEvaluator_ is the utility class for this. It performs the SpEL context creation as well as parses the expressions inside the mappings (marked as #{}).

This was just quick example, but things can get more complicated with mappings. This is why the model is enhanced with other helper annotations and SpEL capabilities. For example:

```java
public class Workout {

  @FieldMapping(value = "workoutStarted", expression = " != null ? 'Yes' : 'No'")
  protected ActivityCollection activities;
}
```

In this case, imagine we want a JSON that has the field _workoutStarted_. Imagine the only way to know this through the XML is to check if the workout has a list of activities. Using the SpEL expression we evaluate if the list is empty to map the _workoutStarted_ value (Yes/No).
