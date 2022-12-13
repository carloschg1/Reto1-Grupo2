net accounts /lockoutthreshold: 3

net accounts /lockoutduration: 120

net accounts /lockoutwindow:120

net accounts /maxpwage:30

net accounts /minpwage:1

net accounts /minpwlen:8

net accounts /uniquepw:6

secedit /export /cfg c:\secpol.cfg
(GC C:\secpol.cfg) -Replace "PasswordComplexity = 0","PasswordComplexity = 1" | Out-File C:\secpol.cfg
secedit /configure /db c:\windows\security\local.sdb /cfg c:\secpol.cfg /areas SECURITYPOLICY
Remove-Item C:\secpol.cfg -Force
