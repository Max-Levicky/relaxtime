package relaxtime.core.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import relaxtime.lib.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Service
public class GroupService {
    public List<Group> combineNewGroups() {
        ArrayList<Group> groups = new ArrayList<Group>();
        groups.add(new Group(
                Lists.newArrayList(new User(1,
                        new PersonalInformation(1, "qwe", "ads", new Date()),
                        new Department())),
                new RelaxMethod()));
        return groups;
    }
}
