class MyLinkedList<T> {
    private var head: Node<T>? = null
    private var size: Int = 0

    class Node<T>(var data: T, var next: Node<T>?)

    private fun addFirst(data: T) {
        val newNode = Node(data = data, next = null)
        size++
        if (head == null) {
            head = newNode
            return
        }
        newNode.next = head
        head = newNode
    }

    private fun addLast(data: T) {
        val newNode = Node(data = data, next = null)
        var currNode = head
        size++
        if (currNode == null) {
            head = newNode
            return
        }
        while (currNode?.next != null) {
            currNode = currNode.next
        }
        currNode?.next = newNode

    }

    private fun add(data: T) {
        addLast(data)
    }

    private fun printList() {
        var currentNode = head
        while (currentNode != null) {
            print("${currentNode.data} -> ")
            currentNode = currentNode.next
        }

        println("NULL ($size)")

    }

    private fun deleteFirst() {
        println("Delete first")
        if (head == null || head?.next == null) {
            head = null
            size = 0
            return
        }
        size--
        head = head?.next
    }

    private fun deleteLast() {
        println("Delete last")
        if (head == null || head?.next == null) {
            head = null
            size = 0
            return
        }
        var prevNode = head
        var currNode = head?.next
        while (currNode?.next != null) {
            prevNode = currNode
            currNode = currNode.next
        }
        size--
        prevNode?.next = null
    }

    private fun get(i: Int): Node<T>? {
        var pointer = 0;
        if (i < 0 || i >= size) return null

        var currentNode = head
        while (pointer < i) {
            currentNode = currentNode?.next
            pointer++
        }

        return currentNode
    }

    private fun reverse() {
        var prevNode: Node<T>? = null
        var currentNode = head

        while (currentNode != null) {
            var nextNode = currentNode?.next
            currentNode.next = prevNode
            prevNode = currentNode
            currentNode = nextNode
        }
        head = prevNode
    }




    companion object {
        @JvmStatic
        fun main(str: Array<String>) {
            val list = MyLinkedList<Int>()

            list.addLast(1)
            list.addLast(2)
            list.add(3)

            list.addLast(4)
            list.printList()
            list.reverse()
            list.printList()
//            list.deleteFirst()
//            list.printList()
//            list.deleteLast()
//            list.printList()
//
//            list.get(-1)?.let { println(it.data) }
//            list.get(1)?.let { println(it.data) }
//            list.get(2)?.let { println(it.data) }
        }

    }


}