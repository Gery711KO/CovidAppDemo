package hu.kocsisgeri.bitraptors.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B1\u0012*\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00050\u0004\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J7\u0010\u000f\u001a\u00020\u00102*\u0010\u0011\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00050\u0004\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\tJ\u001a\u0010\u0014\u001a\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005J\u0014\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lhu/kocsisgeri/bitraptors/ui/adapter/DiffListAdapter;", "Lcom/hannesdorfmann/adapterdelegates4/AsyncListDifferDelegationAdapter;", "Lhu/kocsisgeri/bitraptors/ui/adapter/ListItem;", "adapters", "", "Lcom/hannesdorfmann/adapterdelegates4/AdapterDelegate;", "", "([Lcom/hannesdorfmann/adapterdelegates4/AdapterDelegate;)V", "itemsCount", "", "getItemsCount", "()I", "listItems", "getListItems", "()Ljava/util/List;", "addDelegates", "", "delegates", "notifyItemUpdate", "pos", "setFallbackDelegate", "delegate", "updateData", "list", "Companion", "app_debug"})
public final class DiffListAdapter extends com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter<hu.kocsisgeri.bitraptors.ui.adapter.ListItem> {
    @org.jetbrains.annotations.NotNull()
    public static final hu.kocsisgeri.bitraptors.ui.adapter.DiffListAdapter.Companion Companion = null;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<hu.kocsisgeri.bitraptors.ui.adapter.ListItem> diffCallback = null;
    
    public DiffListAdapter(@org.jetbrains.annotations.NotNull()
    com.hannesdorfmann.adapterdelegates4.AdapterDelegate<java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem>>... adapters) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem> getListItems() {
        return null;
    }
    
    public final int getItemsCount() {
        return 0;
    }
    
    public final void addDelegates(@org.jetbrains.annotations.NotNull()
    com.hannesdorfmann.adapterdelegates4.AdapterDelegate<java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem>>... delegates) {
    }
    
    public final void setFallbackDelegate(@org.jetbrains.annotations.NotNull()
    com.hannesdorfmann.adapterdelegates4.AdapterDelegate<java.util.List<hu.kocsisgeri.bitraptors.ui.adapter.ListItem>> delegate) {
    }
    
    public final void notifyItemUpdate(int pos) {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends hu.kocsisgeri.bitraptors.ui.adapter.ListItem> list) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lhu/kocsisgeri/bitraptors/ui/adapter/DiffListAdapter$Companion;", "", "()V", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lhu/kocsisgeri/bitraptors/ui/adapter/ListItem;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}