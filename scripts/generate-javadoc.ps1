$ErrorActionPreference = 'Stop'
$javadoc = Join-Path $env:LOCALAPPDATA 'Programs\FinancAppTools\jdk17\bin\javadoc.exe'

if (-not (Test-Path $javadoc)) {
    throw 'JDK 17 portátil não encontrado em %LOCALAPPDATA%\Programs\FinancAppTools\jdk17.'
}

& $javadoc -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 -d docs -sourcepath src/main/java -subpackages calculadora
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}

if (-not (Test-Path '.\docs\index.html')) {
    throw 'O JavaDoc terminou sem gerar docs/index.html.'
}

Write-Output 'JavaDoc gerado em docs/index.html.'
