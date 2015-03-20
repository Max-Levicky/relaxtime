package relaxtime.lib.service;

import relaxtime.lib.exception.CrudServiceException;
import relaxtime.lib.exception.ItemNotFoundException;
import relaxtime.lib.model.Department;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Filter;

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
