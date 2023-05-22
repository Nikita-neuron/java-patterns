package practice_3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ListImpl<T> implements List {
    private static final Semaphore semaphore = new Semaphore(1);
    private ArrayList<T> arrayList = new ArrayList<>();

    @Override
    public int size() {
        try {
            semaphore.acquire();
            return arrayList.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            return arrayList.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            return arrayList.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public Iterator iterator() {
        try {
            semaphore.acquire();
            return arrayList.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            return arrayList.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public Object[] toArray(Object[] a) {
        try {
            semaphore.acquire();
            return arrayList.toArray(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean add(Object o) {
        try {
            semaphore.acquire();
            return arrayList.add((T) o);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            return arrayList.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean addAll(Collection c) {
        try {
            semaphore.acquire();
            return arrayList.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean addAll(int index, Collection c) {
        try {
            semaphore.acquire();
            return arrayList.addAll(index, c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            arrayList.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public Object get(int index) {
        try {
            semaphore.acquire();
            return arrayList.get(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public Object set(int index, Object element) {
        try {
            semaphore.acquire();
            return arrayList.set(index, (T) element);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public void add(int index, Object element) {
        try {
            semaphore.acquire();
            arrayList.add(index, (T) element);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object remove(int index) {
        try {
            semaphore.acquire();
            return arrayList.remove(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public int indexOf(Object o) {
        try {
            semaphore.acquire();
            return arrayList.indexOf(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            semaphore.acquire();
            return arrayList.lastIndexOf(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public ListIterator listIterator() {
        try {
            semaphore.acquire();
            return arrayList.listIterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public ListIterator listIterator(int index) {
        try {
            semaphore.acquire();
            return arrayList.listIterator(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        try {
            semaphore.acquire();
            return arrayList.subList(fromIndex, toIndex);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean retainAll(Collection c) {
        try {
            semaphore.acquire();
            return arrayList.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        try {
            semaphore.acquire();
            return arrayList.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        try {
            semaphore.acquire();
            return arrayList.containsAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            semaphore.release();
        }
    }
}
