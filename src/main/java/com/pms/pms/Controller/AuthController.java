package com.pms.pms.Controller;

import com.pms.pms.Dto.JWTAuthResponse;
import com.pms.pms.Dto.LoginDto;
import com.pms.pms.Dto.SignUpDto;
import com.pms.pms.Entity.User;
import com.pms.pms.Repository.UserRepository;
import com.pms.pms.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//@Api(value = "Auth controller exposes siginin and signup REST APIs")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private  final AuthenticationManager authenticationManager;


    private final  UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;


    private  final JwtTokenProvider tokenProvider;

    //@ApiOperation(value = "REST API to Register or Signup user to Blog app")
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

   // @ApiOperation(value = "REST API to Signin or Login user to Blog app")
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

//        // add check for username exists in a DB
//        if(userRepository.existsByEmail(signUpDto.getEmail())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail()))
        {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
       user.setFirstName(signUpDto.getFirstName());
       user.setLastName(signUpDto.getLastName());
       user.setPhone(signUpDto.getPhone());
       user.setEmail(signUpDto.getEmail());
       user.setPassword(signUpDto.getPassword());
       user.setRole(signUpDto.getRole());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

       // Role roles = roleRepository.findByName("ROLE_ADMIN").get();
       // user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
