package de.jplag.cpp;

import java.io.File;

import de.jplag.TokenList;

public class Language implements de.jplag.Language {
    private final Scanner scanner; // cpp code is scanned not parsed

    public Language() {
        scanner = new Scanner();
    }

    @Override
    public String[] suffixes() {
        return new String[] {".cpp", ".CPP", ".cxx", ".CXX", ".c++", ".C++", ".c", ".C", ".cc", ".CC", ".h", ".H", ".hpp", ".HPP", ".hh", ".HH"};
    }

    @Override
    public String getName() {
        return "C/C++ Scanner [basic markup]";
    }

    @Override
    public String getShortName() {
        return "cpp";
    }

    @Override
    public int minimumTokenMatch() {
        return 12;
    }

    @Override
    public TokenList parse(File dir, String[] files) {
        return this.scanner.scan(dir, files);
    }

    @Override
    public boolean hasErrors() {
        return this.scanner.hasErrors();
    }
}
