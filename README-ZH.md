侧滑菜单
===========

侧滑菜单有很多，比较有名有：SlidingMenu...。但是它功能太多，其实我们有时侯仅仅需要一个功能点：侧滑。

LeftSliderLayout的出现就是解决了这个问题。它很简单只有一个java源文件，使用起来也很方便。有很多应用都在使用它。

它实现的原理很简单：在一个FrameLayout下有二个子布局，一个是菜单，另一个是LeftSliderLayout。当向右拖动LeftSliderLayout时，就显示露出菜单布局。而向左拖动LeftSliderLayout时，就覆盖菜单布局。


它的使用也简单：创建一个FrameLayout，在FrameLayout添加二个布局：菜单布局和LeftSliderLayout。其中，菜单布局的宽度要与LeftSliderLayout的SLIDING_WIDTH保持一致。而LeftSliderLayout下面可以放二个子布局：第一个是阴影布局（左边阴影），第二个是要拖动的内容。

LeftSliderLayout有一个Listener。它有二个函数，一个是LeftSliderLayout的打开与关闭的状态改变；另一个是InterceptTouchEvent的回调，主要解决的是在拖动内容中有要处理左右滑动的控件与LeftSliderLayout的左右滑动的事件有冲突，当它返回true时，LeftSliderLayout会处理左右滑动，当它返回false时，就不处理左右滑动的事件。
