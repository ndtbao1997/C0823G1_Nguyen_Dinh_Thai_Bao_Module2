package ss12_java_collection_framework.exec.use_tree;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();

    int getSize();
}
