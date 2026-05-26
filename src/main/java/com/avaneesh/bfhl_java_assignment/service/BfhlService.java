package com.avaneesh.bfhl_java_assignment.service;



import com.avaneesh.bfhl_java_assignment.dto.BfhlRequest;
import com.avaneesh.bfhl_java_assignment.dto.BfhlResponse;

public interface BfhlService {

    BfhlResponse processData(BfhlRequest request);
}
