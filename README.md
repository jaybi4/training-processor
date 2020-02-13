# Training Processor
The use case of this project is to parse an input XML and map it to a different structure (e.g. JSON).

Spring ASM is used to parse the classes graph and compute the SpEL (Spring Expression Language) for the fields annotated.

The output is a map we can use afterwards to retrieve the mapped value by invoking the SpEL expression.
