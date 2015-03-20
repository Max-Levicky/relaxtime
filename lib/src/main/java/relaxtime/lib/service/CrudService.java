package relaxtime.lib.service;

import relaxtime.lib.exception.ItemNotFoundException;
import relaxtime.lib.exception.CrudServiceException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Filter;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public interface CrudService<T> {
    public List<T> getList();
    public List<T> getList(@NotNull Filter filter) throws ItemNotFoundException;
    public T getByIds(@NotNull int... ids) throws ItemNotFoundException;
    public void save(@NotNull T item) throws CrudServiceException;
    public void update(@NotNull T item) throws CrudServiceException;
    public void delete(@NotNull T item) throws CrudServiceException;
}
