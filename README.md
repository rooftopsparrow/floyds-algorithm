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
$ java Floyd < tab.table
# tab.table
5
0	1	-1	1	5
9	0	3	2	-1
-1	-1	0	4	-1
-1	-1	2	0	3
3	-1	-1	-1	0
```

## Output
```text
D0 matrix
0	1	-	1	5
9	0	3	2	-
-	-	0	4	-
-	-	2	0	3
3	-	-	-	0
D1 matrix
0	1	-	1	5
9	0	3	2	14₁
-	-	0	4	-
-	-	2	0	3
3	4₁	-	4₁	0
D2 matrix
0	1	4₂	1	5
9	0	3	2	14₁
-	-	0	4	-
-	-	2	0	3
3	4₁	7₂	4₁	0
D3 matrix
0	1	4₂	1	5
9	0	3	2	14₁
-	-	0	4	-
-	-	2	0	3
3	4₁	7₂	4₁	0
D4 matrix
0	1	3₄	1	4₄
9	0	3	2	5₄
-	-	0	4	7₄
-	-	2	0	3
3	4₁	6₄	4₁	0
D5 matrix
0	1	3₄	1	4₄
8₅	0	3	2	5₄
10₅	11₅	0	4	7₄
6₅	7₅	2	0	3
3	4₁	6₄	4₁	0
```
## Test

```bash
make test
JUnit version 4.11
....
Time: 0.005

OK (4 tests)
```