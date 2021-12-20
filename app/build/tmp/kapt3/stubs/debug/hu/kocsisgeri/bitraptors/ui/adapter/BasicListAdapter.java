package hu.kocsisgeri.bitraptors.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B1\u0012*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00060\u0005\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J7\u0010\u000f\u001a\u00020\u00102*\u0010\u0011\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00060\u0005\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\tJ\u001a\u0010\u0014\u001a\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006J\u0014\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lhu/kocsisgeri/bitraptors/ui/adapter/BasicListAdapter;", "Lcom/hannesdorfmann/adapterdelegates4/ListDelegationAdapter;", "", "Lhu/kocsisgeri/bitraptors/ui/adapter/ListItem;", "adapters", "", "Lcom/hannesdorfmann/adapterdelegates4/AdapterDelegate;", "([Lcom/hannesdorfmann/adapterdelegates4/AdapterDelegate;)V", "itemsCount", "", "getItemsCount", "()I", "listItems", "getListItems", "()Ljava/util/List;", "addDelegates", "", "delegates", "notifyItemUpdate", "pos", "setFallbackDelegate", "delegate", "updateData", "list", "Lhu/kocsisgeri/bitraptors/data/dao/Person;", "app_debug"})
public class BasicListAdapter extends com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter<java.util.List<? extends hu.kocsisgeri.bitraptors.ui.adapter.ListItem>> {
    
    public BasicListAdapter(@org.jetbrains.annotations.NotNull()
    com.hannesdorfmann.adapterdelegates4.AdapterDelegate<java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem>>... adapters) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem> getListItems() {
        return null;
    }
    
    public final int getItemsCount() {
        return 0;
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<hu.kocsisgeri.bitraptors.data.dao.Person> list) {
    }
    
    public final void notifyItemUpdate(int pos) {
    }
    
    public final void addDelegates(@org.jetbrains.annotations.NotNull()
    com.hannesdorfmann.adapterdelegates4.AdapterDelegate<java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem>>... delegates) {
    }
    
    public final void setFallbackDelegate(@org.jetbrains.annotations.NotNull()
    com.hannesdorfmann.adapterdelegates4.AdapterDelegate<java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem>> delegate) {
    }
}