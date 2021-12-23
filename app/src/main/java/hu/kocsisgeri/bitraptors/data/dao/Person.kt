package hu.kocsisgeri.bitraptors.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.kocsisgeri.bitraptors.ui.adapter.ListItem

@Entity(tableName = "person")
data class Person(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "person_sex") var sex: String,
    @ColumnInfo(name = "person_age") var age: Int,
    @ColumnInfo(name = "person_baseIllness") var baseIllnesses: String
) {

    override fun toString(): String {
        return "$id - [$sex] - $age years old\n"
    }
}