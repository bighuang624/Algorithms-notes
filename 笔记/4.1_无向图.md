# 4.1 无向图

## 术语表

* 自环：一条连接一个顶点和其自身的边；
* 平行边：连接同一对顶点的两条边；
* 多重图：含有平行边的图；
* 简单图：没有平行边或自环的图；
* 子图：由一幅图的所有边的一个子集（以及它们所依附的所有顶点）组成的图；

* **路径**：由边顺序连接的一系列顶点；
* 简单路径：一条没有重复顶点的路径；
* 环：一条至少含有一条边且起点与终点相同的路径；
* 简单环：一条（除了起点和终点必须相同之外）不含有重复顶点和边的环；

* 连通图：从任意一个顶点都存在一条路径到达另一个任意顶点的图；
* 一幅**非连通的图**由若干连通的部分组成，它们都是其极大连通子图。一般来说，**要处理一张图就需要一个个地处理它的连通分量（子图）**；

* 树：一幅无环连通图；
* 森林：互不相连的树组成的集合；
* 连通图的生成树：它的一幅子图，它含有图中的所有顶点且是一棵树；
* 图的生成树森林：它的所有连通子图的生成树的集合；

* 图的密度：已经连接的**顶点对**占所有可能被连接的**顶点对**的比例；

* 二分图：一种能将所有结点分成两部分的图，其中图的每条边所连接的两个顶点都分别属于不同的部分；

## 树的数学性质

当且仅当一幅含有 V 个结点的图 G 满足下列 5 个条件之一时，它就是一棵树：

* G 有 V-1 条边且不含有环；
* G 有 V-1 条边且是连通的；
* G 是连通的，但删除任意一条边都会使它不再连通；
* G 是无环图，但添加任意一条边都会产生一条环；
* G 中的任意一对顶点之间仅存在一条简单路径。

## 图的表示方法

* 邻接矩阵
* 边的数组
* 邻接表数组

## 深度优先搜索（DFS）

### 实现方法

在访问其中一个顶点时：

* 将它**标记为已访问**；
* 递归地访问它的所有没被标记过的邻居顶点。

### 命题

* 深度优先搜索标记与起点连通的所有顶点所需的时间和顶点的度数之和成正比。
* 深度优先搜素中每条边都会被访问两次。
* 深度优先搜索的预处理使用的时间和空间与 V+E 成正比，且可以在常数时间内处理关于图的连通性查询。

### 解决问题

* 连通性：两个给定的顶点是否连通；
* 单点路径：能够解决**找出**两个给定顶点间的路径的问题；
* 检测环：给定的图是否为无环图；
* 双色问题：给定的图是否为二分图；

## 广度优先搜索（BFS）

### 实现方法

使用一个队列来保存所有已经被标记过但其邻接表还未被检查过的顶点。先将起点加入队列，然后重复以下步骤直到队列为空：

* 取队列中的下一个顶点 v 并标记它；
* 将与 v 相邻的所有未被标记过的顶点加入队列。

### 命题

* 广度优先搜索所需时间在最坏情况下和 V+E 成正比。

## 总结

问题 | 解决方法 
:-----------: | :-----------: 
单点连通性        | [DepthFirstSearch](https://github.com/bighuang624/Algorithms-notes/blob/master/code/chapter4_1_Undirected_Graphs/DepthFirstSearch.java)   
单点路径         | [DepthFirstPaths](https://github.com/bighuang624/Algorithms-notes/blob/master/code/chapter4_1_Undirected_Graphs/DepthFirstPaths.java)       
单点最短路径         | [BreadthFirstPaths](https://github.com/bighuang624/Algorithms-notes/blob/master/code/chapter4_1_Undirected_Graphs/BreadthFirstPaths.java)   
连通性         | [CC](https://github.com/bighuang624/Algorithms-notes/blob/master/code/chapter4_1_Undirected_Graphs/CC.java)、union-find  
检测环         | [Cycle](https://github.com/bighuang624/Algorithms-notes/blob/master/code/chapter4_1_Undirected_Graphs/Cycle.java)  
双色问题（图的二分性）         | [TwoColor](https://github.com/bighuang624/Algorithms-notes/blob/master/code/chapter4_1_Undirected_Graphs/TwoColor.java)