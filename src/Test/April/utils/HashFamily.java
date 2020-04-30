package Test.April.utils;

public interface HashFamily<Integer> {
    int hash(Integer x,int which);
    int getNumberOfFunctions();
    void generateNewFunctions();
}
