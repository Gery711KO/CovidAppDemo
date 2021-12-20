package hu.kocsisgeri.bitraptors.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\fJ\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fJ\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lhu/kocsisgeri/bitraptors/data/repository/CovidRepository;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "dao", "Lhu/kocsisgeri/bitraptors/data/dao/PersonDao;", "webScrape", "Lhu/kocsisgeri/bitraptors/data/scrapper/WebScrapper;", "(Lkotlin/coroutines/CoroutineContext;Lhu/kocsisgeri/bitraptors/data/dao/PersonDao;Lhu/kocsisgeri/bitraptors/data/scrapper/WebScrapper;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getCovidList", "Lkotlinx/coroutines/flow/Flow;", "Lhu/kocsisgeri/bitraptors/data/repository/ApiResult;", "", "Lhu/kocsisgeri/bitraptors/data/dao/Person;", "getCovidMaxId", "", "getCovidVaccinated", "getDatabaseSize", "", "app_debug"})
public final class CovidRepository implements kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    private final hu.kocsisgeri.bitraptors.data.dao.PersonDao dao = null;
    private final hu.kocsisgeri.bitraptors.data.scrapper.WebScrapper webScrape = null;
    
    public CovidRepository(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull()
    hu.kocsisgeri.bitraptors.data.dao.PersonDao dao, @org.jetbrains.annotations.NotNull()
    hu.kocsisgeri.bitraptors.data.scrapper.WebScrapper webScrape) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<hu.kocsisgeri.bitraptors.data.repository.ApiResult<java.util.List<hu.kocsisgeri.bitraptors.data.dao.Person>>> getCovidList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getDatabaseSize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getCovidVaccinated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getCovidMaxId() {
        return null;
    }
}