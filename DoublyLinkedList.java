public class DoublyLinkedList<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int itemCount;

    private static class Node<Item> {
        private Item item;
        private DoublyLinkedList.Node<Item> next;
        private DoublyLinkedList.Node<Item> previous;
    }


    public Item get(Integer addy) {
        Node curNode = head;
        int thingCounter = 0;
        while(curNode.next != null) {
            if (thingCounter == addy) {
                return (Item) curNode.item;
            }
            curNode = curNode.next;
            thingCounter++;
        }
        return null;
    }


    public void set(Integer addy, Item newItem) {
        Node currentNode = head;
        int counter = 0;
        while(currentNode.next != null) {
            if (counter == addy) {
                currentNode.item = newItem;
            }
            currentNode = currentNode.next;
            counter++;
        }
    }


    public void ExtraSpecialInsertAtBeginning(Item newItem) {
        Node newFirst = new Node<Item>();
        newFirst.item = newItem;
        itemCount++;
        if (head == null) {
            head = newFirst;
            tail = newFirst;
        } else {
            Node oldFirst = head;
            head = newFirst;
            newFirst.next = oldFirst;
            oldFirst.previous = newFirst;
            newFirst.previous = null;
        }
    }


    public void insertCaboose(Item newItem) {
        Node newLast = new Node<Item>();
        newLast.item = newItem;
        itemCount++;
        if (tail == null) {
            tail = newLast;
            head = newLast;
            newLast.next = null;
            newLast.previous = null;
        } else {
            newLast.previous = tail;
            tail.next = newLast;
            tail = newLast;
            newLast.next = null;
        }
    }


    public void insertBeforeSpecNode(Integer index, Item newItem) {
        Node currentNode = head;
        int counter = 0;
        itemCount++;

        while (currentNode != null) {
            if (counter == index) {
                Node newNode = new Node<Item>();
                newNode.item = newItem;

                newNode.previous = currentNode.previous;
                currentNode.previous = newNode;
                newNode.next = currentNode;

                if (head == currentNode) {
                    head = newNode;
                } else {
                    newNode.previous.next = newNode;
                }
                return;
            }
            counter++;
            currentNode = currentNode.next;
        }
    }


    public void insertAfterSpecNode(Integer index, Item newItem) {
        Node currentNode = head;
        int counter = 0;
        itemCount++;

        while (currentNode != null) {
            if (counter == index) {
                Node newNode = new Node<Item>();
                newNode.item = newItem;

                newNode.next = currentNode.next;
                currentNode.next = newNode;
                newNode.previous = currentNode;

                if (tail == currentNode) {
                    tail = newNode;
                } else {
                    newNode.next.previous = newNode;
                }
                return;
            }
            counter++;
            currentNode = currentNode.next;
        }
    }


    public void removeHead() {
        if (head == null) {
            return;
        } else {
            Node newFirst = head.next;
            head.next = null;
            newFirst.previous = null;
            head = newFirst;
            itemCount--;
        }
    }


    public void removeCaboose() {
        if (tail == null) {
            return;
        } else if (tail.previous == null) {
            tail = null;
            head = null;
            itemCount--;
        } else {
            tail = tail.previous;
            tail.next = null;
            itemCount--;
        }
    }


    public void removeSpecNode(Integer index) {
        Node currentNode = head;
        int counter = 0;
        itemCount--;

        while (currentNode != null) {
            if (counter == index) {
                if (head == currentNode) {
                    head = currentNode.next;
                    head.previous = null;
                } else if (tail == currentNode) {
                    tail = currentNode.previous;
                    tail.next = null;
                } else {
                    currentNode.previous.next = currentNode.next;
                    currentNode.next.previous = currentNode.previous;
                }
                return;
            }
            counter++;
            currentNode = currentNode.next;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList testList = new DoublyLinkedList<String>();
        testList.ExtraSpecialInsertAtBeginning("Hi Jacob");
        testList.ExtraSpecialInsertAtBeginning("Monday");
        testList.ExtraSpecialInsertAtBeginning("CodeWithMeJacob!!");
        testList.ExtraSpecialInsertAtBeginning("Apple");
        testList.insertCaboose("Tuesday");
        testList.insertAfterSpecNode(2, "FacobFaytin");
        testList.insertBeforeSpecNode(3, "Enigma");
        testList.ExtraSpecialInsertAtBeginning("Sunday");
        testList.insertBeforeSpecNode(6, "Good.");
        testList.insertBeforeSpecNode(2, "Bonk");
        testList.insertBeforeSpecNode(10, "ILoveCode!!!!!!!!!");
        testList.insertBeforeSpecNode(5, "DryCat");
        testList.removeHead();
        testList.removeCaboose();
        testList.removeSpecNode(3);


        Node curNode4445 = testList.head;

        for (int i = 0; i < testList.itemCount; i++) {
            System.out.println(testList.get(i));
        }
        System.out.println(testList.get(11));
    }
}