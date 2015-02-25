package relaxtime.api.service;

import com.sun.istack.internal.NotNull;
import relaxtime.api.exception.CrudServiceException;
import relaxtime.api.exception.ItemNotFoundException;
import relaxtime.api.util.Filter;

import java.util.List;

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
