package tm.integracja.Projekt.integracja.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.entity.SubBranch;
import tm.integracja.Projekt.integracja.repository.BranchRepository;
import tm.integracja.Projekt.integracja.repository.SubBranchRepository;
import tm.integracja.Projekt.integracja.rest.model.BranchResponse;
import tm.integracja.Projekt.integracja.rest.model.SubBranchResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BranchController {

    private final BranchRepository branchRepository;
    private final SubBranchRepository subBranchRepository;

    @GetMapping("/branches")
    public List<BranchResponse> getBranches() {

        return branchRepository.findAll()
                .stream()
                .map(b -> new BranchResponse(
                        b.getName(),
                        b.getSubBranches()
                                .stream()
                                .map(SubBranch::getName)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Deprecated
    @GetMapping("/subbranches/{branchId}")
    public List<SubBranchResponse> getSubBranches(@PathVariable long branchId) {

        return subBranchRepository.findByBranchId(branchId)
                .stream()
                .map(b -> new SubBranchResponse(b.getId(), b.getName()))
                .collect(Collectors.toList());

    }
}
