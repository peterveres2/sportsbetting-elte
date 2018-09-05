package com.epam.training.sportsbetting.web.transformers;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTransformer<T, U> {
    public abstract U transform(T entity);

    public List<U> transform(List<T> entities) {
        List<U> models = new ArrayList<>(entities.size());
        entities.stream().map(this::transform).forEach(models::add);
        return models;
    }
}
