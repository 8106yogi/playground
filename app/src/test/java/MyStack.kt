class MyStack {

    var head: Node? = null

    class Node(var data: Int, var next: Node?)

    private fun isEmpty(): Boolean {
        return head == null
    }

    private fun push(newData: Int) {
        var newNode = Node(newData, null)
        if (isEmpty()) {
            head = newNode
            return
        }
        newNode.next = head
        head = newNode
    }

    private fun pop(): Int? {
        if (isEmpty()) {
            return -1
        }
        var data = head?.data

        head = head?.next
        return data
    }

    private fun peek(): Int? {
        if (isEmpty()) {
            return -1
        }
        return head?.data
    }


    companion object {
        @JvmStatic
        fun main(str: Array<String>) {
            println("hello my statck")

            var myStack = MyStack()

            myStack.push(1)
            myStack.push(2)
            myStack.push(3)
            myStack.push(4)

            while (!myStack.isEmpty()){
                println(myStack.pop())

            }

        }

    }

}

