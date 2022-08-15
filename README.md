# mathUtils

## Contents

Utility           | Description
:---------------: | :----------
Limit.clamp       | takes 3 numbers. A lower bound an upper bound and a value to be restricted to be between the lower and upper bound
Limit.inRange     | takes 3 numbers. A lower bound an upper bound and a value to be checked to be between the lower and upper bound
Limit.assertLimit | takes 3 numbers. A lower bound an upper bound and a value to be asserted to be between the lower and upper bound. If this condition is not met an exception will get thrown
Range   | an iterable that either supplies an index, an element or both (see example)
Min     | contains min functions for every primitive (see java.lang.Math#min)
Max     | contains max functions for every primitive (see java.lang.Math#max)

## Download

java version | library version | Download
:----------: | :-------------: | :-------
18+          | 1.0.0           | [math_utils-1.0.0.jar]()

## Examples
#### Range
```java
String[] array = { "Hello,", "Range!" };
for (var ie : Range.range(array))
  System.out.println(ie.index() + " -- " + ie.element());
```
Output:
```bash
0 -- Hello,
1 -- Range!
```
#### Range.index()
```java
String[] array = { "Hello,", "Range!" };
for (IndexElement<String> ie : Range.range(array))
  System.out.println(ie.index() + " -- " + ie.element());
```
Output:
```bash
0
1
```
#### Range.element()
```java
String[] array = { "Hello,", "Range!" };
for (String element : Range.range(array).element())
  System.out.println(element);
```
Output:
```bash
Hello,
Range!
```
#### int Range
```java
int start = 1, stop = 5;
for (int i : Range.range(start, stop))
  System.out.println(i);
```
Output:
```bash
1
2
3
4
```
#### String Range
```java
for (char c : Range.range("AbC").reverse().element())
	System.out.println(c);
```
Output:
```bash
C
b
A
```
