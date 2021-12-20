package hu.kocsisgeri.bitraptors.ui.decoration;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B/\b\u0016\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ(\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J \u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u0003H\u0002R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R7\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R5\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001d0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b\'\u0010\u001b\u00a8\u00066"}, d2 = {"Lhu/kocsisgeri/bitraptors/ui/decoration/ItemOffsetDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemOffset", "", "(I)V", "topOffset", "bottomOffset", "leftOffset", "rightOffset", "(IIII)V", "context", "Landroid/content/Context;", "itemOffsetId", "(Landroid/content/Context;I)V", "decoration", "Lhu/kocsisgeri/bitraptors/ui/decoration/Decoration;", "getDecoration", "()Lhu/kocsisgeri/bitraptors/ui/decoration/Decoration;", "differentDecoration", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "item", "getDifferentDecoration", "()Lkotlin/jvm/functions/Function1;", "setDifferentDecoration", "(Lkotlin/jvm/functions/Function1;)V", "firstHasSideOffset", "", "getFirstHasSideOffset", "()Z", "setFirstHasSideOffset", "(Z)V", "lastHasSideOffset", "getLastHasSideOffset", "setLastHasSideOffset", "offsetPredicate", "getOffsetPredicate", "setOffsetPredicate", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getSideOffset", "isSelectedPosition", "showOffset", "offset", "app_debug"})
public final class ItemOffsetDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    @org.jetbrains.annotations.NotNull()
    private final hu.kocsisgeri.bitraptors.ui.decoration.Decoration decoration = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> offsetPredicate;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<java.lang.Object, hu.kocsisgeri.bitraptors.ui.decoration.Decoration> differentDecoration;
    private boolean firstHasSideOffset = true;
    private boolean lastHasSideOffset = true;
    
    @org.jetbrains.annotations.NotNull()
    public final hu.kocsisgeri.bitraptors.ui.decoration.Decoration getDecoration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> getOffsetPredicate() {
        return null;
    }
    
    public final void setOffsetPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Object, hu.kocsisgeri.bitraptors.ui.decoration.Decoration> getDifferentDecoration() {
        return null;
    }
    
    public final void setDifferentDecoration(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, hu.kocsisgeri.bitraptors.ui.decoration.Decoration> p0) {
    }
    
    public final boolean getFirstHasSideOffset() {
        return false;
    }
    
    public final void setFirstHasSideOffset(boolean p0) {
    }
    
    public final boolean getLastHasSideOffset() {
        return false;
    }
    
    public final void setLastHasSideOffset(boolean p0) {
    }
    
    public ItemOffsetDecoration(int itemOffset) {
        super();
    }
    
    public ItemOffsetDecoration(int topOffset, int bottomOffset, int leftOffset, int rightOffset) {
        super();
    }
    
    public ItemOffsetDecoration(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @androidx.annotation.DimenRes()
    int itemOffsetId) {
        super();
    }
    
    @java.lang.Override()
    public void getItemOffsets(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect outRect, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State state) {
    }
    
    private final int getSideOffset(boolean isSelectedPosition, boolean showOffset, int offset) {
        return 0;
    }
}