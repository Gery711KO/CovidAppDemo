package hu.kocsisgeri.bitraptors.data.dao;

import java.lang.System;

@androidx.room.Entity(tableName = "person")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lhu/kocsisgeri/bitraptors/data/dao/Person;", "Lhu/kocsisgeri/bitraptors/ui/adapter/ListItem;", "id", "", "sex", "", "age", "baseIllnesses", "(ILjava/lang/String;ILjava/lang/String;)V", "getAge", "()I", "setAge", "(I)V", "getBaseIllnesses", "()Ljava/lang/String;", "setBaseIllnesses", "(Ljava/lang/String;)V", "getId", "getSex", "setSex", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
public final class Person implements hu.kocsisgeri.bitraptors.ui.adapter.ListItem {
    @androidx.room.PrimaryKey()
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "person_sex")
    private java.lang.String sex;
    @androidx.room.ColumnInfo(name = "person_age")
    private int age;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "person_baseIllness")
    private java.lang.String baseIllnesses;
    
    @org.jetbrains.annotations.NotNull()
    public final hu.kocsisgeri.bitraptors.data.dao.Person copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String sex, int age, @org.jetbrains.annotations.NotNull()
    java.lang.String baseIllnesses) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    public Person(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String sex, int age, @org.jetbrains.annotations.NotNull()
    java.lang.String baseIllnesses) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSex() {
        return null;
    }
    
    public final void setSex(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getAge() {
        return 0;
    }
    
    public final void setAge(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBaseIllnesses() {
        return null;
    }
    
    public final void setBaseIllnesses(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public int getAdapterItemHash() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAdapterItemId() {
        return null;
    }
}