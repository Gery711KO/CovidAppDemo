package hu.kocsisgeri.bitraptors.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lhu/kocsisgeri/bitraptors/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lhu/kocsisgeri/bitraptors/data/repository/CovidRepository;", "(Lhu/kocsisgeri/bitraptors/data/repository/CovidRepository;)V", "covids", "Landroidx/lifecycle/LiveData;", "Lhu/kocsisgeri/bitraptors/data/repository/ApiResult;", "", "Lhu/kocsisgeri/bitraptors/data/dao/Person;", "getCovids", "()Landroidx/lifecycle/LiveData;", "dbSize", "", "getDbSize", "maxId", "", "getMaxId", "vaccinated", "getVaccinated", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<hu.kocsisgeri.bitraptors.data.repository.ApiResult<java.util.List<hu.kocsisgeri.bitraptors.data.dao.Person>>> covids = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> dbSize = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> vaccinated = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> maxId = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    hu.kocsisgeri.bitraptors.data.repository.CovidRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<hu.kocsisgeri.bitraptors.data.repository.ApiResult<java.util.List<hu.kocsisgeri.bitraptors.data.dao.Person>>> getCovids() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getDbSize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getVaccinated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getMaxId() {
        return null;
    }
}