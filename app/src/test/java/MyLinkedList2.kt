class MyLinkedList2<T> {
    var head: Node<T>? = null

    class Node<T>(var data: T, var next: Node<T>?)


    private fun isEmpty(): Boolean {
        return (head == null)
    }

    private fun addFirst(data: T) {
        var newNode = Node(data, next = null)
        if (isEmpty()) {
            head = newNode
            return
        }
        newNode.next = head
        head = newNode
    }

    private fun addLast(data: T) {
        var newNode: Node<T> = Node(data = data, next = null)
        if (isEmpty()) {
            head = newNode
            return
        }
        var currentNode = head
        while (currentNode?.next != null) {
            currentNode = currentNode.next
        }
        currentNode?.next = newNode


    }


    private fun printList() {
        var currentNode = head
        while (currentNode != null) {
            print("${currentNode.data} -> ")
            currentNode = currentNode.next
        }
        println("null")


    }


    companion object {
        @JvmStatic
        fun main(str: Array<String>) {
            val ll = MyLinkedList2<Int>()
            ll.addFirst(0)
            ll.addLast(1)
            //  ll.addFirst(2)
            ll.printList()


            var n=0
            var s1=0
            var s2=1

            while(s1<10){
                n=s1+s2
                print(n)
                s1=s2
                s2=n


            }



        }

    }

}