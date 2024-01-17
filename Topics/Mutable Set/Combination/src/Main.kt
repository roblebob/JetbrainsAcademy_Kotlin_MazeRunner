fun solution(setSource: Set<String>, listSource: MutableList<String>): MutableSet<String> =
    setSource.toMutableSet().apply { addAll(listSource) }
