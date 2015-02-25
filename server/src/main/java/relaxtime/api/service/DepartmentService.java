package relaxtime.api.service;

import com.sun.istack.internal.NotNull;
import relaxtime.api.exception.CrudServiceException;
import relaxtime.api.exception.ItemNotFoundException;
import relaxtime.lib.model.Department;
import relaxtime.api.util.Filter;

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
