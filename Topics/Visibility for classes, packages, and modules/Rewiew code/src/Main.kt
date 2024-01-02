open class BrokenPrivateBase {
    protected val brokenPrivateTaskProperty: String = "Private property"
    protected fun brokenPrivateTaskFunction() {
        println("Private function")
    }
}

class BrokenPrivateDerived : BrokenPrivateBase() {
    fun showBrokenPrivateElements() {
        println(brokenPrivateTaskProperty)
        brokenPrivateTaskFunction() 
    }
}