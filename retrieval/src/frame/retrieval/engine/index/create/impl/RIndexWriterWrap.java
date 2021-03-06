package frame.retrieval.engine.index.create.impl;

import org.apache.commons.logging.Log;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;

import frame.retrieval.engine.common.RetrievalUtil;

/**
 * IndexWriter对象外覆类
 * @author 
 *
 */
public class RIndexWriterWrap {
	private Log log=RetrievalUtil.getLog(this.getClass());

	private Directory directory;
	private IndexWriter indexWriter;
	
	public RIndexWriterWrap(){
		
	}

	/**
	 * 获取IndexWriter相关的Directory对象
	 * @return
	 */
	public Directory getDirectory() {
		return directory;
	}

	/**
	 * 设置IndexWriter相关的Directory对象
	 * @param directory
	 */
	public void setDirectory(Directory directory) {
		this.directory = directory;
	}

	/**
	 * 获取IndexWriter对象
	 * @return
	 */
	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	/**
	 * 设置IndexWriter对象
	 * @param indexWriter
	 */
	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}
	
	/**
	 * 关闭IndexWriter对象相关资源
	 */
	public void close(){
		try{
			if(indexWriter!=null){
				indexWriter.close();
			}
		}catch(Exception e){
			RetrievalUtil.errorLog(log, e);
		}
		
		try{
			if(directory!=null){
				directory.close();
			}
		}catch(Exception e){
			RetrievalUtil.errorLog(log, e);
		}

	}
	
	
}
