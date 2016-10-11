package swt;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Janela1 extends Composite {
	private Text txtNome;
	private Button RdioMasc;
	private Button RdioFem;
	private Table table;
	private ArrayList<Pessoa> cadastro = new ArrayList<Pessoa>();
	private ArrayList<Pessoa> temp = new ArrayList<Pessoa>();
	private Text text;
	private Text txtIdade;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Janela1(Composite parent, int style) {
		super(parent, style);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 39, 21);
		lblNewLabel.setText("Nome");
		
		Label lblIdade = new Label(this, SWT.NONE);
		lblIdade.setText("Idade");
		lblIdade.setBounds(10, 37, 39, 21);
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(55, 10, 272, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(10, 80, 243, 34);
		
		RdioMasc = new Button(grpSexo, SWT.RADIO);
		RdioMasc.setBounds(10, 0, 106, 21);
		RdioMasc.setText("Masculino");
		
		RdioFem = new Button(grpSexo, SWT.RADIO);
		RdioFem.setText("Feminino");
		RdioFem.setBounds(125, 0, 106, 21);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(Janela1.class, "/imgs/add.png"));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pessoa p = lerJanela();
				if(p!=null){
					cadastro.add(p);
					limpajanela();
					preencheTabela(null);
				}
			}
		});
		btnNewButton.setBounds(286, 37, 111, 34);
		btnNewButton.setText("Adicionar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int index = table.getSelectionIndex();
				preencheJanela(temp.get(index));
			}
		});
		table.setBounds(20, 151, 430, 139);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setWidth(173);
		tblclmnNewColumn.setText("Nome");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(150);
		tblclmnNewColumn_1.setText("Idade");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Sexo");
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setBounds(20, 120, 32, 21);
		lblFiltro.setText("Filtro");
		
		text = new Text(this, SWT.BORDER);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				preencheTabela(text.getText());
			}
		});
		text.setText("");
		text.setBounds(55, 120, 342, 24);
		
		txtIdade = new Text(this, SWT.BORDER);
		txtIdade.setBounds(55, 37, 76, 21);

	}
	
	private void mensagem(String titulo, String texto){
		MessageBox m = new MessageBox(getShell(), SWT.ICON_INFORMATION | SWT.YES | SWT.NO);
		m.setText(titulo);
		m.setMessage(texto);
		m.open();
	}
	
	private Pessoa lerJanela(){
		Pessoa p = new Pessoa();
		try{	
			p.setNome(txtNome.getText());
			p.setIdade(Integer.parseInt(txtIdade.getText()));
			p.setSexo(RdioMasc.getSelection()?'M':'F');
		}catch(NumberFormatException e){
			mensagem("Dados Inválidos", "Mensagem deve ser numérico");
		}catch(Exception e){
			mensagem("Erro desconhecido", "Contate o suporte");
		}
		return p;
	}
	
	private void preencheJanela(Pessoa p){
		txtNome.setText(p.getNome());
		txtIdade.setText(p.getIdade()+"");
		RdioMasc.setSelection(p.getSexo()=='M'?true:false);
		RdioFem.setSelection(p.getSexo()=='F'?true:false);
	}
	
	private void limpajanela(){
		txtNome.setText("");
		txtIdade.setText("");
		RdioMasc.setSelection(true);
		RdioFem.setSelection(false);
	}
	
	private void preencheTabela(String filtro){
		table.setItemCount(0);
		temp.clear();
		for(Pessoa p: cadastro){
			if(filtro == null)
				temp.add(p);
			else{
				if(p.getNome().startsWith(filtro))
					temp.add(p);
			}
		}
		for (Pessoa p : temp) {
			TableItem it= new TableItem(table, SWT.NONE);
			it.setText(p.toArray());
			
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
