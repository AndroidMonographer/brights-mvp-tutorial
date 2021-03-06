package com.examples.bright.tutorial.domainlayer.interactors.comics;

import com.examples.bright.tutorial.datalayer.comics.ComicsService;
import com.examples.bright.tutorial.domainlayer.interactors.UseCase;
import com.examples.bright.tutorial.domainlayer.mappers.ComicMapper;
import com.examples.bright.tutorial.domainlayer.model.Comic;

import java.util.List;

import rx.Observable;

/**
 * Created by bright on 17/07/2017.
 */

public class GetComicsUseCase extends UseCase implements GetComicsInteractor {

    private final ComicsService comicsService;

    public GetComicsUseCase(final ComicsService comicsService) {
        this.comicsService = comicsService;
    }

    @Override
    public Observable<List<Comic>> getComics(final int limit) {
        return comicsService.getComics(limit)
                .map(ComicMapper::transformComics)
                .map(comics -> checkOurLimitMatchesOurReturnedResults(limit, comics))
                .compose(applySchedulers());
    }

    private static List<Comic> checkOurLimitMatchesOurReturnedResults(
            final int limit, final List<Comic> comics) {

        final int size = comics.size();
        if(limit != comics.size()) {
            throw new IllegalStateException("You requested a limit of " + limit + " " +
                    "records but, the actual returned records was " + size);
        }
        return comics;
    }
}
