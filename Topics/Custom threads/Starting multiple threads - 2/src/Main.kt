fun main() {
    // create threads and start them using the class RunnableWorker
    repeat(3) {
        val thread = Thread(RunnableWorker(), "worker-$it")
        thread.start()
    }

}

// Don't change the code below       
class RunnableWorker : Runnable {
    override fun run() {
        val name = Thread.currentThread().name
        if (name.startsWith("worker-")) {
            println("too hard calculations...")
        } else {
            return
        }
    }
}