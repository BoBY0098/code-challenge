package com.example.igap.service;

import com.example.igap.dao.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private ProfileRepository profileRepository;

}
