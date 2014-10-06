# Floyd's Algorithm


Given a directed graph, find the total weight of the 
shortest path between any pair of distinct vertices.

Author: Jonathan Nicholson  
Available on [Github](https://github.com/rooftopsparrow/floyds-algorithm)

## Getting Started

Clone this repo and run the following:

```bash
make deps # fetch dependencies
make # build Java files
java Floyd # start program
```

## Usage

Manual entry:

```bash
$ java Floyd
How many vertices?
5
Enter weights between each vertex. One per line or separated by tabs.
Use -1 to indicate that there is no edge between two vertices.
0	1	-1	1	5
9	0	3	2	-1
-1	-1	0	4	-1
-1	-1	2	0	3
3	-1	-1	-1	0
```

Using Redirects:

```bash
java Floyd < tab.table

# tab.table
5
0	1	-1	1	5
9	0	3	2	-1
-1	-1	0	4	-1
-1	-1	2	0	3
3	-1	-1	-1	0
```

## Output
```
D0 matrix
0	1	-	1	5
9	0	3	2	-
-	-	0	4	-
-	-	2	0	3
3	-	-	-	0
D1 matrix
0	1	-	1	5
9	0	3	2	14
-	-	0	4	-
-	-	2	0	3
3	4	-	4	0
D2 matrix
0	1	4	1	5
9	0	3	2	14
-	-	0	4	-
-	-	2	0	3
3	4	7	4	0
D3 matrix
0	1	4	1	5
9	0	3	2	14
-	-	0	4	-
-	-	2	0	3
3	4	7	4	0
D4 matrix
0	1	3	1	4
9	0	3	2	5
-	-	0	4	7
-	-	2	0	3
3	4	6	4	0
D5 matrix
0	1	3	1	4
8	0	3	2	5
10	11	0	4	7
6	7	2	0	3
3	4	6	4	0
```
## Test

```bash
make test
JUnit version 4.11
....
Time: 0.005

OK (4 tests)
```