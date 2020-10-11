# Hash表

* 散列表用的是数组支持按照下标随机访问数据的特性，所以散列表其实就是数组的一种扩展，由数组演化而来

* 散列函数，顾名思义，它是一个函数。我们可以把它定义成 hash(key)，其中 key 表示元素的键值，hash(key) 的值表示经过散列函数计算得到的散列值。

* 散列函数设计的基本要求

  ~~~
  1.散列函数计算得到的散列值是一个非负整数；
  2.如果 key1 = key2，那 hash(key1) == hash(key2)；
  3.如果 key1 ≠ key2，那 hash(key1) ≠ hash(key2)
  ~~~

* 散列冲突: 再好的散列函数也无法避免散列冲突。常用的散列冲突解决方法有两类，开放寻址法（open addressing）和链表法（chaining）。

* 为了尽可能保证散列表的操作效率，一般情况下，我们会尽可能保证散列表中有一定比例的空闲槽位。我们用装载因子（load factor）来表示空位的多少。

  ~~~
  装载因子的计算公式是：散列表的装载因子=填入表中的元素个数/散列表的长度
  装载因子越大，说明散列表中的元素越多，空闲位置越少，散列冲突的概率就越大
  ~~~

* 链表法

  ~~~
  在散列表中，每个“桶（bucket）”或者“槽（slot）”会对应一条链表，所有散列值相同的元素我们都放到相同槽位对应的链表中。
  ~~~

* 当数据量比较小、装载因子小的时候，适合采用开放寻址法。这也是 Java 中的ThreadLocalMap使用开放寻址法解决散列冲突的原因。

* 基于链表的散列冲突处理方法比较适合存储大对象、大数据量的散列表，而且，比起开放寻址法，它更加灵活，支持更多的优化策略，比如用红黑树代替链表。

# 二叉树

* 链表是特殊的树，树是特殊的图

  ~~~
  public class TreeNode { 
  	public int val;
  	public TreeNode left, right; 
  	public TreeNode(int val) {
  		this.val = val; 
  		this.left = null; 
  		this.right = null;
  	} 
  }
  ~~~

* 二叉树遍历

* ~~~
  1.前序(Pre-order):根-左-右 
  2.中序(In-order):左-根-右 
  3.后序(Post-order):左-右-根
  ~~~

* 示例-递归

  ~~~
  //前序
  public static void preorder(TreeNode treeNode, List<Integer> res) {
          if (treeNode == null)
              return;
          res.add(treeNode.val);
          preorder(treeNode.left, res);
          preorder(treeNode.right, res);
  }
  //中序
  public static void inorder(TreeNode treeNode, List<Integer> res) {
          if (treeNode == null)
              return;
          inorder(treeNode.left, res);
          res.add(treeNode.val);
          inorder(treeNode.right, res);
  }
  //后序
    public static void postorder(TreeNode treeNode, List<Integer> res) {
          if (treeNode == null)
              return;
          postorder(treeNode.left, res);
          postorder(treeNode.right, res);
          res.add(treeNode.val);
    }
  ~~~

# 二叉搜索树

~~~
二叉搜索树，也称二叉排序树、有序二叉树(Ordered Binary Tree)、排 序二叉树(Sorted Binary Tree)，是指一棵空树或者具有下列性质的二叉 树:
1. 左子树上所有结点的值均小于它的根结点的值;
2. 右子树上所有结点的值均大于它的根结点的值;
3. 以此类推:左、右子树也分别为二叉查找树。 (这就是 重复性!)
中序遍历:升序排列
~~~

# 堆/二叉堆

* 可以迅速找到一堆数中最大或者最小值的数据结构

* 将根结点最大的堆叫做大顶堆或大根堆，根结点最小的堆叫做小顶堆或小根堆，常见的堆有二叉堆，斐波那契堆

* 二叉堆

* ~~~
  1.堆是一个完全二叉树；
  2.堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
  ~~~

  