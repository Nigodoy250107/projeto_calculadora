$ErrorActionPreference = 'Stop'
$toolsRoot = Join-Path $env:LOCALAPPDATA 'Programs\FinancAppTools'
$javaHome = Join-Path $toolsRoot 'jdk17'
$mavenHome = Join-Path $toolsRoot 'maven'

if (-not (Test-Path (Join-Path $javaHome 'bin\java.exe')) -or
    -not (Test-Path (Join-Path $mavenHome 'bin\mvn.cmd'))) {
    throw 'JDK/Maven portáteis não encontrados em %LOCALAPPDATA%\Programs\FinancAppTools.'
}

$env:JAVA_HOME = $javaHome
$env:PATH = (Join-Path $javaHome 'bin') + ';' + (Join-Path $mavenHome 'bin') + ';' + $env:PATH
& (Join-Path $mavenHome 'bin\mvn.cmd') clean test
exit $LASTEXITCODE
