package relaxtime.service;

import com.sun.istack.internal.NotNull;
import relaxtime.exception.CrudServiceException;
import relaxtime.exception.ItemNotFoundException;
import relaxtime.model.Department;
import relaxtime.util.Filter;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class DepartmentService extends BaseService implements CrudService<Department> {
    @Override
    public List<Department> getList() {
        return null;
    }

    @Override
    public List<Department> getList(@NotNull Filter filter) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Department getByIds(@NotNull int... ids) throws ItemNotFoundException {
        int global;
        return null;
    }

    @Override
    public void save(@NotNull Department item) throws CrudServiceException {

    }

    @Override
    public void update(@NotNull Department item) throws CrudServiceException {

    }

    @Override
    public void delete(@NotNull Department item) throws CrudServiceException {

    }
}
