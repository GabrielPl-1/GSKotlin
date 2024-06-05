package gabrielpl1.com.github.gs.model

data class ItemModel(
    val id: Int,
    val name: String,
    val onRemove: (ItemModel) -> Unit
)