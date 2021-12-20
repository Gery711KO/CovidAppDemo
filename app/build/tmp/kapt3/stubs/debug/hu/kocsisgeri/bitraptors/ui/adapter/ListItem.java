package hu.kocsisgeri.bitraptors.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lhu/kocsisgeri/bitraptors/ui/adapter/ListItem;", "", "getAdapterItemHash", "", "getAdapterItemId", "", "app_debug"})
public abstract interface ListItem {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getAdapterItemId();
    
    public abstract int getAdapterItemHash();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static java.lang.String getAdapterItemId(@org.jetbrains.annotations.NotNull()
        hu.kocsisgeri.bitraptors.ui.adapter.ListItem $this) {
            return null;
        }
        
        public static int getAdapterItemHash(@org.jetbrains.annotations.NotNull()
        hu.kocsisgeri.bitraptors.ui.adapter.ListItem $this) {
            return 0;
        }
    }
}