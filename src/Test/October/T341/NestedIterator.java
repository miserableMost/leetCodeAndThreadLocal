package Test.October.T341;

/*
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
        index = -1;
    }

    @Override
    public Integer next() {
        if(this.hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        //倒数第二个
        if(index + 1 < list.size())
            return true;
        return false;
    }

    public static List<Integer> integerIterator(List<NestedIterator> nestedIntegerList) {
        ArrayList<Integer> list = new ArrayList<>(nestedIntegerList.size());
        for (NestedIterator cur : nestedIntegerList) {
            if(cur.isInteger()) {
                list.add(tmp.getInteger());
            }else {
                list.addAll(integerIterator(cur.getList()));
            }
        }
        return list;
    }
}
*/
