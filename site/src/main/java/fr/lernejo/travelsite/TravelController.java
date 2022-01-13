package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TravelController {

    public final ArrayList<UserList> listUserList = new ArrayList<UserList>();
    public final ArrayList<DestinationList> listDestinationList = new ArrayList<DestinationList>();

    @RequestMapping(value = ("/api/inscription"), method= RequestMethod.POST)
        public ArrayList<UserList> Inscription(@RequestBody UserList newUser) {
            listUserList.add(newUser);
            return listUserList;
        }

        @RequestMapping(value = ("/api/travels"),  method=RequestMethod.GET)
        public Iterable<DestinationList> getDestinationList(@RequestParam String userName) {
            listDestinationList.add(new DestinationList("Tunisia", 37.9));
            listDestinationList.add(new DestinationList("USA", 22.9));
            return this.listDestinationList;
        }
}
