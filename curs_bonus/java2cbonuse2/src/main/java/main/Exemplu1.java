package main;

import dto.UserDto;
import model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class Exemplu1 {

    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<User, UserDto>() {
            @Override
            protected void configure() {
                // regula aplicata la maparea de la User la UserDto
                // care specifica faptul ca
                // User#name corespunde lui UserDto#fullName
                map(source.getName(), destination.getFullName());
            }
        });
    }

    public static void main(String[] args) {
        User user = new User("gigel", "1234");
        user.setName("gigel ion");

        //UserDto userDto = convertToDto(user);
        UserDto userDto = modelMapper.map(user, UserDto.class);

        System.out.println(userDto);
    }

    private static UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
