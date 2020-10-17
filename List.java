package com.company;

public class List {

        class Item {
            private int value;
            private Item next;


            public Item(int value) {
                this.value = value;
                this.next = null;
            }


            public boolean hasNext() {
                if (this.next != null) {
                    return true;
                } else {
                    return false;
                }
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public Item getNext() {
                return next;
            }

            public void setNext(Item next) {
                this.next = next;
            }

            public String toString() {
                return Long.toString(this.value);
            }
        }

        private Item begin;
        private long counter;

        public List() {
            this.begin = null;
            this.counter = 0;
        }

        public long getCounter() {
            return counter;
        }

        public void add(int value) {
            Item item = new Item(value);
            if (this.begin == null)
                this.begin = item;
            else {
                end().setNext(item);
            }
            this.counter++;
        }

        public Item end() {
            if (this.begin == null)
                return null;
            Item iter = this.begin;
            while (iter.hasNext()) {
                iter = iter.getNext();
            }
            return iter;
        }

        public String toString() {
            String result = "[";
            if (this.begin == null)
                return null;
            else {
                Item iter = this.begin;
                while (iter.hasNext()) {
                    result += iter.toString() + ", ";
                    iter = iter.getNext();
                }
                result += iter.toString();
            }
            result += " ]";
            return result;
        }

        public void swap(int posOne, int posTwo) {
            int change;
            if (posTwo < posOne) {
                change = posTwo;
                posTwo = posOne;
                posOne = change;
            }
            Item first = indexAt(posOne);
            Item second = indexAt(posTwo);
            Item preFirst = indexAt(posOne - 1);
            Item preSecond = indexAt(posTwo - 1);
            Item postFirst = indexAt(posOne + 1);
            Item postSecond = indexAt(posTwo + 1);
            if((posTwo >= 0) && (posTwo <= counter - 1) && (posOne >= 0) && (posOne <= counter - 1) && (posOne != posTwo)) {
                if (posOne == 0) {
                    if(posTwo - posOne == 1) {
                        first.setNext(postSecond);
                        second.setNext(first);
                        this.begin = second;
                    }
                    else {
                        preSecond.setNext(first);
                        first.setNext(postSecond);
                        this.begin = second;
                        second.setNext(postFirst);
                    }
                } else {
                    if(posTwo - posOne == 1) {
                        first.setNext(postSecond);
                        second.setNext(first);
                        preFirst.setNext(second);
                    } else {
                        preFirst.setNext(second);
                        second.setNext(postFirst);
                        preSecond.setNext(first);
                        first.setNext(postSecond);
                    }
                }
            }

        }

        public Item indexAt(int index) {

            if ((index <= this.counter - 1 ) && (index >=0)) {
                Item iter = this.begin;
                for (int i=0; i <index; ++i)
                    iter = iter.getNext();
                return iter;
            }
            return null;

        }

        public void sort() {
            int k = 0;
            Item one;
            Item two;
            boolean all = true;
            while (all) {
                for (int i = 1; i <= this.counter - 1; i++) {
                    one = indexAt(i - 1);
                    two = indexAt(i);
                    if (two.getValue() < one.getValue()) {
                        swap(i - 1, i);
                        k++;
                    }

                }
                if (k == 0)
                    all = false;
                k = 0;

            }
        }
    }