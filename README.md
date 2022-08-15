# mathUtils [![Maven Package](https://github.com/tinycodecrank/mathUtils/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/tinycodecrank/mathUtils/actions/workflows/maven-publish.yml)

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
18+          | 1.0.0           | [math_utils-1.0.0.jar](https://github-registry-files.githubusercontent.com/524994046/43357580-1cc7-11ed-85d4-899d45c5e0ce?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20220815%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20220815T162407Z&X-Amz-Expires=300&X-Amz-Signature=94ad15017b05e6303511a97d26b31c2a1632930da67f209e9e0cf943d9d71335&X-Amz-SignedHeaders=host&actor_id=0&key_id=0&repo_id=524994046&response-content-disposition=filename%3Dmath_utils-1.0.0.jar&response-content-type=application%2Foctet-stream)

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
