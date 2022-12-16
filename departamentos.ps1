$file_groups=Import-Csv -Path departamentos.csv
foreach ($group in $file_groups) {
  New-LocalGroup -Name $group.Nombre -Description $group.Descripcion
}
