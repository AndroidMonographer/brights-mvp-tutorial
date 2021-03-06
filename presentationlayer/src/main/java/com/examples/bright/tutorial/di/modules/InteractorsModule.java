package com.examples.bright.tutorial.di.modules;

import com.examples.bright.tutorial.datalayer.comics.ComicsService;
import com.examples.bright.tutorial.domainlayer.interactors.comics.GetComicDetailInteractor;
import com.examples.bright.tutorial.domainlayer.interactors.comics.GetComicsInteractor;
import com.examples.bright.tutorial.domainlayer.interactors.comics.GetComicDetailUseCase;
import com.examples.bright.tutorial.domainlayer.interactors.comics.GetComicsUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * These Interactors may be used anywhere within the app. So make them available by keeping them
 * within their own module since any component in future may want to use them.
 * Created by bright on 17/07/2017.
 */

@Module
public class InteractorsModule {

    /**
     * Since this
     * @param comicsService
     * @return
     */
    @Provides
    public GetComicsInteractor providesGetComicInteractor(ComicsService comicsService) {
        return new GetComicsUseCase(comicsService);
    }

    @Provides
    public GetComicDetailInteractor providesGetComicDetailInteractor() {
        return new GetComicDetailUseCase();
    }
}
