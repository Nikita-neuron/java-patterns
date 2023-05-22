package practice_3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetImpl implements Set {
    private HashSet hashSet = new HashSet();

    @Override
    synchronized public int size() {
        return hashSet.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return hashSet.contains(o);
    }

    @Override
    synchronized public Iterator iterator() {
        return hashSet.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return hashSet.toArray();
    }

    @Override
    synchronized public boolean add(Object o) {
        return hashSet.add(o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return hashSet.remove(o);
    }

    @Override
    synchronized public boolean addAll(Collection c) {
        return hashSet.addAll(c);
    }

    @Override
    synchronized public void clear() {
        hashSet.clear();
    }

    @Override
    synchronized public boolean removeAll(Collection c) {
        return hashSet.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection c) {
        return hashSet.retainAll(c);
    }

    @Override
    synchronized public boolean containsAll(Collection c) {
        return hashSet.containsAll(c);
    }

    @Override
    synchronized public Object[] toArray(Object[] a) {
        return hashSet.toArray(a);
    }
}
