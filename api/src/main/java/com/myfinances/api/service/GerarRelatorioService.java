package com.myfinances.api.service;

import com.myfinances.api.entity.Transacao;
import com.myfinances.api.repository.CategoriaRepository;
import com.myfinances.api.repository.TransacaoRepository;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GerarRelatorioService {

    private final TransacaoRepository transacaoRepository;
    private final CategoriaRepository categoriaRepository;

    public GerarRelatorioService(TransacaoRepository transacaoRepository, CategoriaRepository categoriaRepository){
        this.transacaoRepository = transacaoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public byte[] gerarRelatorio() throws IOException {
        List<Transacao> transacaos = transacaoRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Relatório de Transacoes!");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Descrição");
        header.createCell(2).setCellValue("Tipo de Transacao");
        header.createCell(3).setCellValue("Data da Transacao");
        header.createCell(4).setCellValue("Valor da Transacao");
        header.createCell(5).setCellValue("Categoria");

        int linha = 1;

        for (Transacao transacao : transacaos) {
            Row row = sheet.createRow(linha++);

            row.createCell(0).setCellValue(transacao.getDia());
            row.createCell(1).setCellValue(transacao.getDescricao());
            row.createCell(2).setCellValue(transacao.getTipo().ordinal());
            row.createCell(3).setCellValue(transacao.getDia());
            row.createCell(4).setCellValue((RichTextString) transacao.getValor());
            row.createCell(5).setCellValue(transacao.getCategoria().getNomeCategoria());
        }

        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}
